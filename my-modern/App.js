const APP_TITLE = 'Reactアプリ';

function getTriangle(base, height) {
    return base * height / 2;
}

class Article {
    getAppTitle() {
        return APP_TITLE;
    }
}

export { getTriangle, Article };
