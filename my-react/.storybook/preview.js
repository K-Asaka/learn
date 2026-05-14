/** @type { import('@storybook/react-webpack5').Preview } */
const preview = {
  parameters: {
    actions: { argTypesRegex: "^(on|handle)[A-Z].*" },
    controls: {
      matchers: {
       color: /(background|color)$/i,
       date: /Date$/i,
      },
    },
  },
};

export default preview;