import PropTypes from 'prop-types';

export function Member() {}
function TypeProp(props) {
    console.log(props);
    return <p>結果はコンソールを確認してください。</p>;
}

TypeProp.propTypes = {
    // Member型のプロパティ
    prop1: PropTypes.instanceOf(Member)
};

export default TypeProp;
