import Member from './Member.js';

describe('Jestの基本', () => {
    const NAME = '佐藤理央';
    let m;
    // 前処理
    beforeEach(() => {
        m = new Member(NAME);
    });

    // 後処理
    afterEach(() => {
        console.log('Test is done.');
    });

    // テストケース本体
    it('greetメソッドの確認', () => {
        let result = m.greet();
        expect(m.name).toBe(NAME);
        expect(result).toContain(NAME);
    });
});
