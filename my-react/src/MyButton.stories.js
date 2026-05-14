import MyButton from './MyButton';

// 基本情報を宣言
export default {
    title: 'MyApp/MyButton',
    component: MyButton,
    args: {
        label: 'Push!!',
    },
    argTypes: {
        primary: {
            type: 'boolean',
            description: 'Primaryカラーを有効にするか',
        },
        backgroundColor: {
            type: 'string',
            description: '背景色'
        },
        size: {
            type: {
                name: 'enum',
                value: ['small', 'medium', 'large']
            },
            control: { type: 'select' },
            description: 'ボタンの大きさ'
        },
        label: {
            type: 'string',
            description: 'ボタンのキャプション'
        },
        handleClick: { action: 'clicked' },
    },
};

// Index、Whiteストーリーを追加
export const Index = {
    args: {
        primary: true,
        size: 'medium',
        onClick: () => console.log('Hello, Storybook!!')
    }
};

export const White = {
    args:{
        size:'small',
        label:'ボタン',
        backgroundColor:'#fff',
        primary:false
    }
};

export const Yellow = {
    args: {
        ...White.args,
        backgroundColor: 'lightyellow'
    }
};