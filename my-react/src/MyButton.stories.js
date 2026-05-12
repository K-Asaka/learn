import MyButton from './MyButton';

// 基本情報を宣言
export default {
    title: 'MyApp/MyButton',
    component: MyButton,
    args: {
        label: 'Push!!',
    },
};

// Index、Whiteストーリーを追加
export const Index = {
    render: args => <MyButton {...args} />,
    args: {
        primary: true,
        size: 'medium',
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

export const Yellow = {
    args: {
        ...White.args,
        backgroundColor: 'lightyellow'
    }
};