// EventListenerオブジェクトの準備
let data = {
    mainTitle: 'ゼロからわかる TypeScript入門',
    price: 2948,
    handleEvent() {
        console.log(`${this.mainTitle} ／ ${this.price}円`);
    }
};

document.querySelector('#btn').addEventListener('click', data, false);
