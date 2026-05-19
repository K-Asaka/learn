//import { userEvent, within } from '@storybook/testing-library';
import { userEvent, within, expect, fn } from '@storybook/test';
import { action } from '@storybook/addon-actions';
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
        label: 'ボタン',
        // イベントハンドラーは無効化
        //onClick: () => console.log('Hello, Storybook!!')
        handleClick: fn(),
    },
    play: async ({ args, canvasElement }) => {
        const canvas = within(canvasElement);
        const button = canvas.getByRole('button');
        await userEvent.click(button);
        await userEvent.click(button);
        await expect(args.handleClick).toHaveBeenCalledTimes(2);
    }
};


export const White = {
    args:{
        size:'small',
        label:'ボタン',
        backgroundColor:'#fff',
        handleClick: action('clicked'),
    }
};

export const Yellow = {
    args: {
        ...White.args,
        backgroundColor: 'lightyellow'
    }
};