(function(){
		$.fn.stick =function(){
			var $cur = this,
				offsetTop = $cur.offset().top,
				isFixed = false;
			
			//  设置监听函数
			$(window).on("scroll", function(){
				var winScroll = $(this).scrollTop();
				if(offsetTop < winScroll){
					if(!isFixed){
						setFixed();
					}
				}else{
					if(isFixed){
						unsetFixed();
					}
				}
			});
			// 设置添加和删除stick函数
			function setFixed(){
				$cur.removeClass("navbar-static-top").addClass("navbar-fixed-top");
				isFixed = true;
			}
			function unsetFixed(){
				$cur.removeClass("navbar-fixed-top").addClass("navbar-static-top");
				isFixed = false;
			}
		}
	})();