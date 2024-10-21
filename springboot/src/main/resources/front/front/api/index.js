import http from './http'
import base from './base'

/**
 * 登陆校验
 */
export const auth = () => {
	let token = uni.getStorageSync("token");
	if (!uni.getStorageSync("token")) {
		uni.navigateTo({
			url: '../login/login'
		})
		return
	}
}
/**
 * 登陆
 */
export const login = (tableName, data) => {
	return http.request({
		url: `${tableName}/login`,
		method: 'GET',
		data
	})
}
/**
 * 人脸识别登陆
 */
export const faceLogin = (tableName, data) => {
    return http.request({
        url: `${tableName}/faceLogin`,
        method: 'GET',
        data
    })
}
/**
 *  * 发送邮箱验证码
 *   */
export const sendemail = (tableName, email) => {
	return http.request({
		url: `${tableName}/sendemail?email=${email}`,
		method: 'GET'
	});
}
/**
 *  * 发送短信证码
 *   */
export const sendsms = (tableName, mobile) => {
	return http.request({
		url: `${tableName}/sendsms?mobile=${mobile}`,
		method: 'GET'
	});
}
/**
 *  * 注册
 *   */
export const register = (tableName, data) => {
	let url = `${tableName}/register`;
	return http.request({
		url: url,
		method: 'POST',
		data
	})
}
/**
 *  * 邮箱注册
 *   */
export const registerEmail = (tableName, data, emailcode) => {
    let url = `${tableName}/register?emailcode=${emailcode}`;
	return http.request({
		url: url,
		method: 'POST',
		data
	})
}
/**
 *  * 短信注册
 *   */
export const registerSms = (tableName, data, smscode) => {
    let url = `${tableName}/register?smscode=${smscode}`;
	return http.request({
		url: url,
		method: 'POST',
		data
	})
}
/**
 * 重置密码
 */
export const resetPass = (tableName, username) => {
	let data = {
		username: username
	}
	return http.request({
		url: `${tableName}/resetPass`,
		method: 'GET',
		data
	})
}
/**
 * 获取登陆用户信息
 */
export const session = (tableName) => {
	return http.request({
		url: `${tableName}/session`,
		method: 'GET'
	})
}
/**
 * 查询
 */
export const list = (tableName, data) => {
	return http.request({
		url: `${tableName}/list`,
		method: 'GET',
		data
	});
}
/**
 * 查询 page
 */
export const page = (tableName, data) => {
	return http.request({
		url: `${tableName}/page`,
		method: 'GET',
		data
	});
}
/**
 * 保存
 */
export const add = (tableName, data) => {
	return http.request({
		url: `${tableName}/add`,
		method: 'POST',
		data
	});
}
// 保存
export const save = (tableName, data) => {
	return http.request({
		url: `${tableName}/save`,
		method: 'POST',
		data
	});
}
/**
 * 更新
 */
export const update = (tableName, data) => {
	return http.request({
		url: `${tableName}/update`,
		method: 'POST',
		data
	});
}
export const updateBrowseDuration = (tableName, id, duration, data) => {
    return http.request({
        url: `${tableName}/updateBrowseDuration/`+id+"?duration="+duration,
        method: 'POST',
        data
    });
}
/**
 * 删除
 */
export const del = (tableName, data) => {
	return http.request({
		url: `${tableName}/delete`,
		method: 'POST',
		data
	});
}
/**
 * 单条信息查询
 */
export const info = (tableName, id) => {
	return http.request({
		url: `${tableName}/detail/${id}`,
		method: 'GET'
	});
}
/**
 * 智能推荐
 */
export const recommend = (tableName,data) => {
	return http.request({
		url: `${tableName}/autoSort`,
		method: 'get',
		data
	});
}
/**
 * 智能推荐(按购买类型推荐)
 */
export const recommend2 = (tableName,data) => {
	return http.request({
		url: `${tableName}/autoSort2`,
		method: 'get',
		data
	});
}
/**
 * 上传
 */
export const upload = (callback) => {
	uni.chooseImage({
		count: 4, //默认9
		sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
		//sourceType: ['album'], //从相册选择
		success: (res) => {
			uni.uploadFile({
				url: `${base.url}file/upload`, //仅为示例，非真实的接口地址
				filePath: res.tempFilePaths[0],
				name: 'file',
				header: {
					'Token': uni.getStorageSync("token")
				},
				success: (uploadFileRes) => {
					// console.log(uploadFileRes)
					let result = JSON.parse(uploadFileRes.data);
					if (result.code == 0) {
						callback(result);
					} else {
						uni.showToast({
							title: result.msg,
							icon: 'none',
							duration: 2000
						});
					}
				}
			});
		}
	});
}
/**
 * 垃圾识别
 */
export const rubbish = (tableName, fileName) => {
    return http.request({
        url: `${tableName}/aliyun/rubbish?fileName=`+fileName,
        method: 'GET'
    });
}
/**
 * 百度识别（文字，动物，植物，菜品）
 */
export const baiduIdentify = (tableName, type, fileName) => {
    return http.request({
        url: `${tableName}/baidu/${type}?fileName=`+fileName,
        method: 'GET'
    });
}
export const uploadMedia = (callback) => {
	uni.chooseVideo({
		count: 1,
		sourceType: ['camera', 'album'],
		success: function(res) {
			console.log(res)
			uni.uploadFile({
				url: `${base.url}file/upload`, //仅为示例，非真实的接口地址
				filePath: res.tempFilePath,
				name: 'file',
				header: {
					'Token': uni.getStorageSync("token")
				},
				success: (uploadFileRes) => {
					// console.log(uploadFileRes)
					let result = JSON.parse(uploadFileRes.data);
					if (result.code == 0) {
						callback(result);
					} else {
						uni.showToast({
							title: result.msg,
							icon: 'none',
							duration: 2000
						});
					}
				}
			});
		}
	});
}

/**
 * 获取默认地址
 */
export const defaultAddress = (userid) => {
	return http.request({
		url: `address/default?userid=${userid}`,
		method: 'GET'
	});
}
/**
 * 联动查询
 * @param {*} tableName 
 * @param {*} columnName 
 * @param {*} data 
 */
export const option = (tableName, columnName, data) => {
	return http.request({
		url: `option/${tableName}/${columnName}`,
		method: 'GET',
		data
	});
}
/**
 * 随
 * @param {*} tableName 
 * @param {*} columnName 
 * @param {*} data 
 */
export const follow = (tableName, columnName, data) => {
	return http.request({
		url: `follow/${tableName}/${columnName}`,
		method: 'GET',
		data
	});
}
// 论坛接口
export const allPublicForm = (page = 1, limit = 10, title='%%') => {
	let data = {
		page: page,
		limit: limit,
		title: title
	}
	return http.request({
		url: `forum/flist?parentid=0&isdone=开放&sort=addtime&order=desc`,
		method: 'GET',
		data
	});
}
// 我的帖子
export const myForum = (page = 1, limit = 10) => {
	let data = {
		page: page,
		limit: limit
	}
	return http.request({
		url: `forum/page?parentid=0&sort=addtime&order=desc`,
		method: 'GET',
		data
	});
}
export const forumDetail = (id) => {
	return http.request({
		url: `forum/list/${id}`,
		method: 'GET',
	});
}
export const groupby = () => {
	return http.request({
		url: `examrecord/groupby`,
		method: 'GET',
	});
}
export const deleteRecords = (userid, paperid) => {
	return http.request({
		url: `examrecord/deleteRecords?userid=${userid}&paperid=${paperid}`,
		method: 'POST',
	});
}
export const faceMatch = (data) => {
    return http.request({
        url: `matchFace`,
        method: 'GET',
        data
    });
}
export const security = (tableName, data) => {
    return http.request({
        url: `${tableName}/security`,
        method: 'GET',
        data
    });
}
export default {
	login, // 登陆
	sendemail, //发送邮箱验证码
	sendsms, //发送短信验证码
	register, //注册
	registerEmail, //邮箱注册
	registerSms, //短信注册
	resetPass, // 重置
	auth, // 校验
	session, // 个人信息
	list, // 查询
	page, // 查询 page
	add, // 添加
	update, // 修改
    updateBrowseDuration,
	del, // 删除
	info, // 单条信息查询,
	recommend, // 智能推荐
	recommend2, // 智能推荐(按购买类型推荐)
	defaultAddress, // 默认地址
	save, // 保存
	upload, // 上传
    rubbish,
    baiduIdentify,
	option, // 联动查询
	follow, // 随
	allPublicForm,
	myForum,
	forumDetail,
	groupby,
	deleteRecords,
    faceMatch,
	uploadMedia,
    faceLogin,
    security
}
