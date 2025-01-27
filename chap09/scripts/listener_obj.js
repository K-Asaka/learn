// EventListenerオブジェクトの準備
let data = {
    mainTitle: 'ゼロからわかる TypeScript入門',
    price: 2948,
    handleEvent() {
        console.log(`${this.mainTitle} ／ ${this.price}円`);
    }
};

document.querySelector('#btn').addEventListener('click', data, false);
// thisの変化に注意
document.querySelector('#btn').addEventListener('click', data.handleEvent, false);
// bindメソッドによる解決
document.querySelector('#btn').addEventListener('click', data.handleEvent.bind(data), false);

