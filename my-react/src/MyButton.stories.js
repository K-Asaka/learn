import MyButton from './MyButton';

// 基本情報を宣言
export default {
    title: 'MyApp/MyButton',
    component: MyButton,
};

// Index、Whiteストーリーを追加
export const Index = {
    args: {
        primary: true,
        size: 'medium',
        label: 'ボタン',
        onClick: () => console.log('Hello, Storybook!!')
    }
};

export const White = {
    args: {
        size: 'small',
        label: 'ボタン',
        backgroundColor: '#fff'
    }
};
