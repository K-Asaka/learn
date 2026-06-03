describe('Cypress Sample', () => {
    it('MyReact App Test', () => {
        // トップページにアクセス
        cy.visit('/');

        // 書籍登録フォームに移動し、何も入力せずに[登録]ボタンをクリック
        cy.get('a[href="/book/form"]').click();
        cy.get('[type="submit"]').click();
        cy.get('ul').should('have.length', 2);

        // 書名、価格(不正な値)を入力した状態で[登録]ボタンをクリック
        cy.get('#title').type('速習React');
        cy.get('#price').type('-500');
        cy.get('[type="submit"]').click();
        cy.get('form li:eq(0)').should('contain', '正数');

        // すべてに正しい値を入力した状態で[登録]ボタンをクリック
        cy.get('#price').clear().type('500');
        cy.get('#published').type('2024-01-05');
        cy.get('[type="submit"]').click();
        cy.url().should('equal', 'http://localhost:3000/');
    });
});
