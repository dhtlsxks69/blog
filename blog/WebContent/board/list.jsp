<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>
<!--================Blog Area =================-->
<section class="blog_area p_120">
	<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<div class="blog_left_sidebar">

					<c:forEach var="board" items="${boards}">
						<!-- 				포스팅 시작 -->
						<article class="blog_style1">
							<div class="blog_img">
								<img class="img-fluid" src="${board.previewImg}" alt="">
							</div>
							<div class="blog_text">
								<div class="blog_text_inner">
									<div class="cat">
										<a class="cat_btn" href="#">Gadgets</a> <a href="#"><i class="fa fa-calendar" aria-hidden="true"></i> ${board.createDate}</a> <a href="#"><i class="fa fa-comments-o" aria-hidden="true"></i>
											${board.readCount}</a>
									</div>
									<a href="#"><h4>${board.title}</h4></a>
									<p>${board.content}</p>
									<a class="blog_btn" href="/blog/board?cmd=view&id=${board.id}">Read More</a>
								</div>
							</div>
						</article>
						<!-- 					포스팅 끝	 -->
					</c:forEach>
					<!-- 					페이징 시작 -->
					<nav class="justify-content-center d-flex">
						<a class="blog_btn" href="/blog/board?cmd=list&page=${param.page-1}">Prev</a> <a class="blog_btn" href="/blog/board?cmd=list&page=${param.page+1}">Next</a>
					</nav>
					<!-- 					페이징 끝 -->
				</div>
			</div>
			<div class="col-lg-4">
				<div class="blog_right_sidebar">
					<aside class="single_sidebar_widget search_widget">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search Posts"> <span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="lnr lnr-magnifier"></i>
								</button>
							</span>
						</div>
						<!-- /input-group -->
						<div class="br"></div>
					</aside>

					<aside class="single_sidebar_widget popular_post_widget">
						<h3 class="widget_title">Popular Posts</h3>
						<c:forEach var="board" items="${popularList}">
							<div class="media post_item">
								<!-- 							c:choose는 when(if)과 otherwise(else)가 있음	empty board.previewImg는 previewImg에 Img가 없으면 -->
								<c:choose>
									<c:when test="${empty board.previewImg}">
										<img src="/blog/img/blog/popular-post/123.jpg" width="100px" height="60px" alt="post">
									</c:when>
									<c:otherwise>
										<img src="${board.previewImg}" width="100px" height="60px" alt="post">
									</c:otherwise>
								</c:choose>

								<div class="media-body">
									<a href="/blog/board?cmd=view&id=${board.id}"><h3>${board.title}</h3></a>
									<p>${board.createDate}</p>
								</div>
							</div>
						</c:forEach>
						<div class="br"></div>
					</aside>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================Blog Area =================-->

<%@ include file="/include/footer.jsp"%>

