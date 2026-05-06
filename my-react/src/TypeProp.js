import PropTypes from 'prop-types';

export function Member() {}
function TypeProp(props) {
    console.log(props);
    return <p>結果はコンソールを確認してください。</p>;
}

TypeProp.propTypes = {
    // Member型のプロパティ
    prop1: PropTypes.instanceOf(Member),
    // 男性、女性、その他の中のどれか
    prop2: PropTypes.oneOf(['男性', '女性', 'その他']),
    // 文字列、数値、ブール値のいずれか
    prop3: PropTypes.oneOfType([
        PropTypes.string,
        PropTypes.number,
        PropTypes.bool,
    ]),
    // 数値型の配列
    prop4: PropTypes.arrayOf(PropTypes.number),
    // 数値型のオブジェクト
    prop5: PropTypes.objectOf(PropTypes.number)
};

export default TypeProp;
