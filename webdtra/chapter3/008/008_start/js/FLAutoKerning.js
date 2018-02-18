/*
	カーニングペアの定義
	単位はem。 -0.5(em) でボックス0.5個分詰まる。
	"*く" と定義した場合、"あく"、"いく"、"うく"、というように、全ての"○く"の組み合わせにカーニングが設定される。
	"あく" と定義をした場合、 "あく"という文字のペアのみにカーニングが設定される。
	ワイルドカードペアと直接指定のペアが衝突する場合、直接指定のペアが優先される。
*/
var p = {};

p["都"] = 0;
p["都会"] = 0.06;
p["会と"] = -0.08;
p["と自"] = -0.18;
p["自然"] = 0.02;
p["然の"] = 0;
p["の間"] = 0.02;
p["間で"] = 0.02;
p["暮ら"] = -0.04;
p["らす"] = -0.1;
p["すと"] = -0.18;
p["とい"] = -0.2;
p["いう"] = -0.18;
p["う選"] = -0.1;
p["選択"] = 0.06;
p["択肢"] = 0.06;
p["肢。"] = 0.06;

/*
 * @class FLAutoKerning
 * @version 0.0.3 (2011/02/28)
 * 
 * テキストに文字詰めを適用するUtilityクラス。
 * インスタンス化せずに、スタティック関数として使用する。
 *
 * @author Takayuki Fukatsu, artandmobile.com, fladdict.net
 * @requires jQuery
 */
var FLAutoKerning = {};


/*
 * ディフォルトのカーニング情報を格納した定数。
 * ユーザーが任意のカーニング情報を適用しない場合は、この情報を基準にカーニングが設定される。
 */
FLAutoKerning.DEFAULT_KERNING_INFO = p;


/*
 * 渡された jQuery オブジェクト内のテキストに、字詰めを適用する。
 * 字詰めはスタイルシートのletter-spacingによって実現される。
 * 第2引数を指定することで、ユーザー独自のカーニング情報を適用することも可能。
 * 
 * @param {jQuery} elements テキストを内包したhtml要素の jQuery オブジェクト。
 * @param {Array} kerningInfo カーニングペア情報を格納した配列。省略した場合は、FLAutoKerning.DEFAULT_KERNING_INFO が適用される。
 */
FLAutoKerning.process = function( elements, kerningInfo )
{
	if(kerningInfo==undefined)
		kerningInfo = FLAutoKerning.DEFAULT_KERNING_INFO;
	
	elements.each(
		function(index, element){
			var html = $(element).html();
			var newHtml = "";
			var n = html.length;
			for(var i=0; i<n; i++)
			{
				var char = html.substr(i,1);
				var char2 = char;
				var nextChar = html.substr(i+1,1);
				var space = 0;
				
				if(kerningInfo[char+nextChar]){
					//明示的なカーニングペアの処理
					space = kerningInfo[char+nextChar];
				}else{
					//汎用カーニングペアの処理
					if(kerningInfo[char+"*"] )
						space += kerningInfo[char+"*"];
					if(kerningInfo["*"+nextChar] )
						space += kerningInfo["*"+nextChar];
				}
				if(space!=0)
					char2 = "<span style='letter-spacing:" + space + "em'>" + char + "</span>";
					
				//行頭約物の処理
				if(i == 0 && kerningInfo[char])
					char2 =  "<span style='margin-left:" + kerningInfo[char] + "em'/>" + char2;
					
				newHtml += char2;
			}
			$(element).html(newHtml);
		});
}

//tenpの変数を削除
delete p;