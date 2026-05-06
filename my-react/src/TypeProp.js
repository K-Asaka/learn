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
};

export default TypeProp;
