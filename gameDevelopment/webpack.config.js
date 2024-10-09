const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  // Entry point for your application
  entry: path.join(__dirname, 'index.js'),
  
  // Output configuration for bundled files
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: './index.js',
    clean: true, // Cleans the output directory before each build
  },

  // Development server configuration
//   devServer: {
//     contentBase: path.join(__dirname, 'dist'),
//     compress: true,
//     port: 9000,
//   },

  // Module rules (loaders) for handling different file types
  module: {
    rules: [
      {
        test: /\.css$/, // Rule for CSS files
        use: ['style-loader', 'css-loader'],
      },
      {
        test: /\.(png|jpe?g|gif|svg|woff|woff2|eot|ttf|otf)$/i, // Match your asset file types
        type: 'asset/resource', // Use asset/resource for handling the files
        generator: {
          filename: 'assets/[hash][ext][query]', // Specify the output path in the 'assets' folder
        },
      },
    ],
  },

  // Plugins
  plugins: [
    new HtmlWebpackPlugin({
      template: './index.html', // Path to your HTML file
      filename: 'index.html', // Output file in dist folder
    }),
  ],

  // Mode can be set to 'development' or 'production'
  mode: 'development',
};
