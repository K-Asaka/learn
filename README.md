# 学習記録用リポジトリ

## スッキリわかるPythonによる機械学習

機械学習(machine learning:ML)とは、コンピュータにデータ間の法則を自動的に導き出させる手法の総称。

## 機械学習の種類

- 教師あり学習  
大量の入力データと正解データのペアを与えることで、入力データから正解データを予測するための法則を見つける手法。
    - 回帰  
        数値を予測すること。
    - 分類  
        文字列や範囲の狭い整数など、いくつかの選択肢のうちの1つとして解釈できるデータを予測するものをいう。

- 教師なし学習  
大量の入力データから、入力データ自体の特徴を見つける手法
    - クラスタリング
        似ているデータをグループ分けする手法。
    - 次元削減
        票データなどで各列の特徴を調べて、多数の列項目を少数の列項目にまとめる手法。

## 機械学習の用語
- モデル  
機械学習で利用するデータを与える数式。

## データの種類
- 構造化データ  
数値や文字列や日付など、表形式で管理できるデータ。
    - 量的データ  
        数値データ。
    - 質的データ(カテゴリカルデータ)  
        文字列のデータや、「0、1、2」のように範囲の狭い整数

- 非構造化データ  
画像や映像や文書など、表形式で管理することが難しいデータ。


## 中央地
### 基本統計量
与えられたデータ集合から算出することができる数値指標のこと。

- 平均値  
    データ集合の重心(一般的にはデータの総和を個数で割ったもの)。
- 中央値  
    データ集合の真ん中の値。データ集合を昇順に並べた際に、ちょうど真ん中に位置する値。データの個数が偶数の場合は真ん中の2つのデータの平均を中央値とする。
- 最大値  
    データ集合の一番大きい値。
- 最小値  
    データ集合の一番小さい値。
- 分散  
    データ集合のばらつきを表す指標。
- 標準偏差  
    データ集合のばらつきを表す指標(分散の改良版)。
- 相関係数  
    2項目の関係性の強さの指標。

- 外れ値  
    ほかの値に比べて明らかに大きすぎる値や小さすぎる値。
- 第1四分位数  
    データを小さい順に並べた際の、下半分(小さい方)の中央値。
- 第3四分位数  
    データを小さい順に並べた際の、上半分(大きい方)の中央値。

## 分散
データの集まりがばらついているか、ある一点の付近に集中しているかなどのばらつき具合を表現する数値指標。

### 分散値の計算
- 手順1：平均値を計算する  
    最初にデータの平均値を計算する。

- 手順2：各データについて偏差を計算する  
    各データについて平均値の差分を計算する。この差分のことを偏差と呼ぶ。

    ※偏差が0だったら、そのデータは平均値のすぐ近くに存在し、偏差が大きかったら平均値から遠く離れていることを意味する。  
    ※偏差を計算する時は、常に「データ - 平均値」と計算する。すると、必ず平均値より大きい方のズレ(偏差の符号はプラス)と平均値より小さいほうのズレ(偏差の符号はマイナス)が生じる。そのため、平均を計算するときの分子(合計の計算)でプラスとマイナスの打ち消しが発生し、値が0になってしまう。

- 手順3：偏差の2乗の平均を計算する  
    偏差を2乗すると、元の値がマイナスならプラスになり、プラスならそのままプラスである。この2乗の処理を元の偏差にすることで、プラスとマイナスの打ち消しが無くなる。

    ※分散は値が大きいほど、そのデータ集合がばらついていることを表している。分散を計算することで、2つのデータ集合のばらつきを比較することができる。


### 標準偏差(standard diviation:SD)
分散と同様に「データのばらつき」を表す指標で、分散の平方根をとることにより求められる。  
値が大きければ、よりばらついていることを意味する。  

分散の計算では、プラスとマイナスの打ち消しを防ぐという計算上の都合で2乗した。  
そのため計算結果の単位は元のデータから変わってしまう。  
「途中で2乗したので、最終的に平方根を取ることで単位を戻す」という発想で生まれたのが標準偏差。

### 相関関数
2つの数値列に関して、2列の関係性を測ることのできる統計指標。
- 散布図  
    票データの2つの列のデータを取り出して、それぞれグラフ上にプロットした図。
    2つの項目を散布図にしたとき、右肩上がり(右肩下がり)の傾向を数値化した**相関係数**という指標がある。
    相関係数には次の特徴がある。  
    ※相関係数は、英字のRで表現されるのが一般的。

    - 必ず-1以上+1以下の間の値になる。
    - 正の相関が強いほど、相関係数は+側に大きくなる(+1に近づく)。
    - 負の相関が強いほど、相関係数は-側に大きくなる(-1に近づく)。

    相関係数の値の意味
    | 相関係数の値 | 散布図の解釈 |
    | --- | --- |
    | -1   ～ -0.7 | 強い負の相関(綺麗な右肩下がり) |
    | -0.7 ～ -0.3 | 負の相関(どちらかといえば右肩下がり) |
    | -0.3 ～ +0.3 | 無相関(無秩序)
    | +0.3 ～ +0.7 | 正の相関(どちらかといえば右肩上がり) |
    | +0.7 ～ +1   | 強い正の相関(綺麗な右肩上がり) |

## 統計学でよく使われるグラフ
- ヒストグラム(度数分布図)  
数値データの集合に対して、「その値が何個出現したか」の個数(度数ともいう)を集計して柱状グラフにしたもの。
    - 階級(bin)
    ヒストグラム作成時に設定する区間。
- 箱ひげ図  
中央値や第1四分位数・第3四分位数の値を利用したグラフ。
外れ値の存在を表すため、外れ値を除いたデータの範囲を表すのが箱ひげ図における最大値と最小値。


---

## データの前処理

| 前処理の各作業 | 概要 |
| --- | --- |
| データの統合 | 複数ファイルに分かれているデータをまとめる |
| 欠損値の処理 | 何らかの理由で欠落している値を補足する |
| 外れ値の処理 | 他のデータに対して、明らかに大きすぎたり小さすぎたりするデータを調整する |
| 文字から数値への変換 | 文字データを数値データに変換する |
| データの標準化 | データの分布に偏りがないように調整する |
| 特徴量エンジニアリング | ある特徴量を、分析に適した形へと、様々に変換する |


Pythonでは*pandas*というライブラリを用いると前処理を手軽に行える。

