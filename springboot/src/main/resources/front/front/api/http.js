/**
 * 通用uni-app网络请求
 * 基于 Promise 对象实现更简单的 request 使用方式，支持请求和响应拦截
 */
import base from './base'

export default {
	config: {
		baseUrl: base.url,
		header: {
			'Content-Type': 'application/json;charset=UTF-8'
		},
		data: {},
		method: "GET",
		dataType: "json",
		// responseType: "json",
		success() {},
		fail() {},
		complete() {}
	},
	interceptor: {
		request: null,
		response: null
	},
	request(options) {
		if (!options) {
			options = {}
		}
		options.baseUrl = options.baseUrl || this.config.baseUrl
		options.dataType = options.dataType || this.config.dataType
		options.url = options.baseUrl + options.url
		options.data = options.data || {}
		options.method = options.method || this.config.method
		let token = {'Token': uni.getStorageSync("token")}
		options.header = Object.assign({}, options.header, token) 
		return new Promise((resolve, reject) => {
			let _config = null
			options.complete = (response) => {
				let statusCode = response.statusCode
				response.config = _config
				if (process.env.NODE_ENV === 'development') {
					if (statusCode === 200) {
						// console.log("【" + _config.requestId + "】 结果：" + JSON.stringify(response.data))
					}
				}
				if (this.interceptor.response) {
					let newResponse = this.interceptor.response(response)
					if (newResponse) {
						response = newResponse
					}
				}
				if (statusCode === 200) { //成功
					var rs = response.data;
					if (rs.code === 0) {
						// 请求成功后返回
						resolve(response.data);
					} else if (rs.code == 401) {
						uni.navigateTo({
							url: '../login/login'
						})
					} else {
						uni.showToast({
							title: rs.msg,
							icon: 'none',
							duration: 2000
						});
					}
				} else {
					uni.showToast({
						title: "接口执行异常",
						icon: 'none',
						duration: 2000
					});
					reject(response)
				}
			}
			_config = Object.assign({}, this.config, options)
			_config.requestId = new Date().getTime()
			if (this.interceptor.request) {
				this.interceptor.request(_config)
			}
			if (process.env.NODE_ENV === 'development') {
				// console.log("【" + _config.requestId + "】 地址：" + _config.url)
				if (_config.data) {
					// console.log("【" + _config.requestId + "】 参数：" + JSON.stringify(_config.data))
				}
			}
			uni.request(_config);
		});
	},
	get(url, data, options) {
		if (!options) {
			options = {}
		}
		options.url = url
		options.data = data
		options.method = 'GET'
		return this.request(options)
	},
	post(url, data, options) {
		if (!options) {
			options = {}
		}
		options.url = url
		options.data = data
		options.method = 'POST'
		return this.request(options)
	},
	put(url, data, options) {
		if (!options) {
			options = {}
		}
		options.url = url
		options.data = data
		options.method = 'PUT'
		return this.request(options)
	},
	delete(url, data, options) {
		if (!options) {
			options = {}
		}
		options.url = url
		options.data = data
		options.method = 'DELETE'
		return this.request(options)
	}
}


/**
 * 请求接口日志记录
 */
function _reqlog(req) {
	if (process.env.NODE_ENV === 'development') {
		// console.log("【" + req.requestId + "】 地址：" + req.url)
		if (req.data) {
			// console.log("【" + req.requestId + "】 请求参数：" + JSON.stringify(req.data))
		}
	}
}

/**
 * 响应接口日志记录
 */
function _reslog(res) {
	let _statusCode = res.statusCode;
	if (process.env.NODE_ENV === 'development') {
		// console.log("【" + res.config.requestId + "】 地址：" + res.config.url)
		if (res.config.data) {
			// console.log("【" + res.config.requestId + "】 请求参数：" + JSON.stringify(res.config.data))
		}
		// console.log("【" + res.config.requestId + "】 响应结果：" + JSON.stringify(res))
	}
}
