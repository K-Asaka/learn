Vue.createApp({
  data: function () {
    return {
      prices: [
        { id: 1, text: "～100円" },
        { id: 2, text: "101円～500円" },
        { id: 3, text: "501円～" }
      ],
      activeTab: 1,
      // 商品一覧
      items: [],
      filterText: "",
      filterPriceId: undefined
    }
  },
  computed: {
    filteredItemsByText: function () {
      const self = this
      if (this.filterText) {
        return this.items.filter(function (item) {
          return item.name.indexOf(self.filterText.trim()) !== -1
        })
      } else {
        return this.items
      }
    },
    filteredItemsByPriceId: function () {
      const self = this
      if (this.filterPriceId) {
        return this.items.filter(function (item) {
          switch (self.filterPriceId) {
            case 1:
              return item.price <= 100
            case 2:
              return item.price > 100 && item.price <= 500
            case 3:
              return item.price > 500
            default:
              return item.price >= 0
          }
        })
      } else {
        return this.items
      }
    },
    filteredItems: function () {
      if (this.acitiveWordsTab) {
        return this.filteredItemsByText
      } else if (this.acitivePriceTab) {
        return this.filteredItemsByPriceId
      } else {
        return this.items
      }
    },
    acitiveWordsTab: function () {
      return this.activeTab === 1
    },
    acitivePriceTab: function () {
      return this.activeTab === 2
    }
  },
  methods: {
    changeTab: function (number) {
      this.initialize()
      this.activeTab = number
    },
    initialize: function () {
      this.filterText = ""
      this.filterPriceId = undefined
    },
    // 商品一覧をjsonから取得する
    fetchItem: function () {
      const self = this
      axios.get("./item.json").then(function (response) {
        self.items = response.data
      })
    }
  },
  mounted: function () {
    // アプリケーションが立ち上がったら商品一覧を取得する
    this.fetchItem()
  }
}).mount("#app")
