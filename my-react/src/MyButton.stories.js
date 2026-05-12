import MyButton from './MyButton';

// 基本情報を宣言
export default {
    title: 'MyApp/MyButton',
    component: MyButton,
};

// Index、Whiteストーリーを追加
export const Index = {
    render: () => <MyButton primary size="medium" label="ボタン"
        onClick={() => console.log('Hello, Storybook!!')}/>
};

export const White = {
    render: () => <MyButton size="small" label="ボタン"
        backgroundColor="#fff" />
};
