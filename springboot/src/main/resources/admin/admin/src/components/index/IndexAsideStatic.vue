<template>
	<div class="menu-preview">
		<!-- 竖向 -->
		<el-scrollbar wrap-class="scrollbar-wrapper">
			<el-menu :default-openeds="[]" :unique-opened="true" :style='{"border":0,"padding":"0 0 60px","listStyle":"none","margin":"0 auto","flexWrap":"wrap","background":"none","flexDirection":"column","display":"flex","width":"100%","position":"relative","justifyContent":"center"}' class="el-menu-vertical-demo" default-active="0">
				<el-image v-if="false" :style='{"width":"44px","margin":"10px auto","objectFit":"cover","borderRadius":"100%","display":"block","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
				<!-- <el-menu-item index="0" @click="menuHandler('')">
					<i v-if='false' :style='{"width":"34px","verticalAlign":"middle","margin":"0 3px","fontSize":"18px","color":"inherit","textAlign":"center"}' class="el-icon-menu el-icon-s-home" />
					<span :style='{"color":"inherit","verticalAlign":"middle","fontSize":"14px"}'>系统首页</span>
				</el-menu-item> -->
				
				<el-submenu index="0" @click.native="menuHandler('')">
					<template slot="title">
						<i v-if='false' :style='{"width":"34px","verticalAlign":"middle","margin":"0 3px","fontSize":"18px","color":"inherit","textAlign":"center"}' class="el-icon-menu el-icon-s-home" />
						<span :style='{"color":"inherit","verticalAlign":"middle","fontSize":"14px"}'>系统首页</span>
					</template>
				</el-submenu>
				
				<el-submenu index="1">
					<template slot="title">
						<i v-if='false' :style='{"width":"34px","verticalAlign":"middle","margin":"0 3px","fontSize":"18px","color":"inherit","textAlign":"center"}' class="el-icon-menu el-icon-user-solid" />
						<span :style='{"color":"inherit","verticalAlign":"middle","fontSize":"14px"}'>个人中心</span>
					</template>
					<el-menu-item index="1-1" @click="menuHandler('updatePassword')">修改密码</el-menu-item>
					<el-menu-item index="1-2" @click="menuHandler('center')">个人信息</el-menu-item>
				</el-submenu>
				<el-submenu v-for=" (menu,index) in menuList.backMenu" :key="menu.menu" :index="index+2+''">
					<template slot="title">
						<i v-if='false' :style='{"width":"34px","verticalAlign":"middle","margin":"0 3px","fontSize":"18px","color":"inherit","textAlign":"center"}' class="el-icon-menu" :class="icons[index]" />
						<span :style='{"color":"inherit","verticalAlign":"middle","fontSize":"14px"}'>{{ menu.menu }}</span>
					</template>
					<el-menu-item v-for=" (child,sort) in menu.child" :key="sort" :index="(index+2)+'-'+sort" @click="menuHandler(child.tableName)">{{ child.menu }}</el-menu-item>
				</el-submenu>
			</el-menu>
		</el-scrollbar>

	</div>
</template>

<script>
import menu from '@/utils/menu'
export default {
	data() {
		return {
			menuList: [],
			dynamicMenuRoutes: [],
			role: '',
			icons: [
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-fold',
				'el-icon-s-unfold',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-custom',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check',
				'el-icon-s-grid',
				'el-icon-menu',
				'el-icon-chat-dot-square',
				'el-icon-message',
				'el-icon-postcard',
				'el-icon-position',
				'el-icon-microphone',
				'el-icon-close-notification',
				'el-icon-bangzhu',
				'el-icon-time',
				'el-icon-odometer',
				'el-icon-crop',
				'el-icon-aim',
				'el-icon-switch-button',
				'el-icon-full-screen',
				'el-icon-copy-document',
				'el-icon-mic',
				'el-icon-stopwatch',
			],
			menulistBorderBottom: {},
		}
	},
	mounted() {
		const menus = menu.list()
		if(menus) {
			this.menuList = menus
		} else {
			let params = {
				page: 1,
				limit: 1,
				sort: 'id',
			}
			
			this.$http({
				url: "menu/list",
				method: "get",
				params: params
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.menuList = JSON.parse(data.data.list[0].menujson);
					this.$storage.set("menus", this.menuList);
				}
			})
		}
		this.role = this.$storage.get('role')
		
		for(let i=0;i<this.menuList.length;i++) {
			if(this.menuList[i].roleName == this.role) {
				this.menuList = this.menuList[i];
				break;
			}
		}
		this.styleChange()
	},
	created(){
		this.icons.sort(()=>{
			return (0.5-Math.random())
		})
	},
	methods: {
		
		styleChange() {
			this.$nextTick(() => {
								document.querySelectorAll('.el-menu-vertical-demo .el-submenu .el-menu').forEach(el => {
				  el.removeAttribute('style')
				  const icon = {"border":"none","margin":"20px auto 0px auto","background":"none","display":"none"}
				  Object.keys(icon).forEach((key) => {
					el.style[key] = icon[key]
				  })
				})
											})
		},
		menuHandler(name) {
			let router = this.$router
			name = '/'+name
			router.push(name)
		},
	}
}
</script>
<style lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
		
				// 竖向
		.el-menu-vertical-demo {
		  .el-submenu:first-of-type /deep/ .el-submenu__title .el-submenu__icon-arrow {
		    display: none;
		  }
		}
		
		.el-menu-vertical-demo>.el-menu-item {
				  				  cursor: pointer;
				  				  padding: 0px 15px;
				  				  margin: 0 auto;
				  				  color: #666;
				  				  white-space: nowrap;
				  				  line-height: 40px;
				  				  border-radius: 0 4px 30px 0;
				  				  box-shadow: 4px 4px 0px #ccc;
				  				  background: url(http://codegen.caihongy.cn/20221203/a14e669e5c084257801eac3aa067d8e0.png) left top no-repeat,#f6f6f6;
				  				  width: 100%;
				  				  position: relative;
				  				  text-align: center;
				  				  height: 40px;
				  		}
		
		.el-menu-vertical-demo>.el-menu-item:hover {
						color: #666;
						background: url(http://codegen.caihongy.cn/20221203/a14e669e5c084257801eac3aa067d8e0.png) left top no-repeat,#f6f6f6;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title {
						cursor: pointer;
						padding: 0px 15px;
						margin: 0 auto;
						color: #666;
						white-space: nowrap;
						line-height: 40px;
						border-radius: 0 4px 30px 0;
						box-shadow: 4px 4px 0px #ccc;
						background: url(http://codegen.caihongy.cn/20221203/a14e669e5c084257801eac3aa067d8e0.png) left top no-repeat,#f6f6f6;
						width: 100%;
						position: relative;
						text-align: center;
						height: 40px;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title:hover {
						color: #666;
						background: url(http://codegen.caihongy.cn/20221203/a14e669e5c084257801eac3aa067d8e0.png) left top no-repeat,#f6f6f6;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title .el-submenu__icon-arrow {
						margin: -16px 0 0 0;
						top: 60%;
						color: inherit;
						vertical-align: middle;
						font-size: 14px;
						position: absolute;
						right: 20px;
					}
		
		.el-menu-vertical-demo .el-submenu {
						padding: 0;
						margin: 0 auto 16px auto;
						width: 200px;
						position: relative;
						list-style: none;
					}
		
		// .el-menu-vertical-demo .el-submenu /deep/ .el-menu {
		// 				// 		border: none;
		// 				// 		margin: 20px auto 0px auto;
		// 				// 		background: none;
		// 				// 		display: none;
		// 				// }
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item {
						border-radius: 4px;
						padding: 0 10px;
						margin: 0 auto 6px;
						color: #333;
						background: url(http://codegen.caihongy.cn/20221203/8e49820ace4d4c1392bfbbe018036956.png) right top no-repeat,#eee;
						width: 100%;
						line-height: 36px;
						text-align: center;
						height: 36px;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item:hover {
						border-radius: 4px;
						padding: 0 10px;
						color: #333;
						background: url(http://codegen.caihongy.cn/20221203/8e49820ace4d4c1392bfbbe018036956.png) right top no-repeat,#f6f6f6;
						line-height: 36px;
						height: 36px;
					}
		
		.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item.is-active {
						border-radius: 4px;
						padding: 0 10px;
						color: #333;
						background: url(http://codegen.caihongy.cn/20221203/8e49820ace4d4c1392bfbbe018036956.png) right top no-repeat,#f6f6f6;
						line-height: 36px;
						height: 36px;
					}
		// 竖向
			  }
	  	}
</style>
