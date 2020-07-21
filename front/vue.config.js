const path = require('path');

module.exports = {
	publicPath: '/team6',
	outputDir: path.resolve(__dirname, '../src/main/resources/static'),
	devServer: {
		overlay: false
	},
	configureWebpack: {
		resolve: {
			alias: {
				'@': path.join(__dirname, 'src/')
			}
		}
	}
};
