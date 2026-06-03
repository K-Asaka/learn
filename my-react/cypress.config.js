const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    // 基底パスを定義
    baseUrl: 'http://localhost:3000',
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
