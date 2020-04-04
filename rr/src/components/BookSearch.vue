<template>
    <div id="search">
        <!-- 検索フォームを定義 -->
        <el-form :inline="true">
            <el-form-item label="キーワード">
                <el-input type="text" size="large" v-model="keyword"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onclick">検索</el-button>
            </el-form-item>
        </el-form>
        <hr>
        <!-- マッチした書籍情報をリスト表示 -->
        <BookInfo v-for="(b, i) of books" :linkable="true" :book="b" :index="i + 1" :key="b.isbn"></BookInfo>
    </div>
</template>

<script>
import Bookinfo from '@/components/BookInfo.vue'

export default {
    name: 'book-search',
    // ローカルコンポーネントを登録
    components: {
        BookInfo
    },
    data() {
        return {
            keyword: 'vuejs',   // 検索キーワード
            books: []           // 検索結果
        }
    },
    methods: {
        // [検索]ボタンで書籍情報を検索
        onclick: function() {
            this.$http('https://www.googleapis.com/books/v1/volumes?q='
                + this.keyword)
            // 応答データをJSONデータとして取得
            .then((response) => {
                return response.json()
            })
            // JSON文字列の内容をbooksプロパティ(配列)に詰め替え
            .then((data) => {
                this.books = []
                for (let b of data.items) {
                    let authors = b.volumeInfo.authors
                    let price = b.saleInfo.listPrice
                    let img = b.volumeInfo.imageLinks
                    this.books.push({
                        id: b.id,       // id値
                        title: b.volumeInfo.title,      // 書名
                        author: authors ? authors.join(',') : '',   // 著者
                        price: price ? price.amount : '-',      // 価格
                        publisher: b.volumeInfo.publiser,       // 出版社
                        published: b.volumeInfo.publishedDate,  // 刊行日
                        image: img ? img.smallThumbnail : '',   // 表紙画像
                    })
                }
            })
        }
    }
}
</script>

<style scoped>
#search form {
    margin-top: 15px;
}
</style>
