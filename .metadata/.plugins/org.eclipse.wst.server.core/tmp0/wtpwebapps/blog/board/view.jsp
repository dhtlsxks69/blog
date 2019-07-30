<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>

<!--================Blog Area =================-->
<section class="blog_area p_120 single-post-area">
	<div class="container">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<div class="main_blog_details">
					<a href="#"><h4>${board.title}</h4></a>
					<div class="user_details">

						<div class="float-left">
							<c:if test="${board.username eq sessionScope.username}">
								<a href="/blog/board?cmd=update&id=${board.id}">update</a>
								<a href="/blog/board?cmd=delete&id=${board.id}">delete</a>
							</c:if>
						</div>

						<div class="float-right">
							<div class="media">
								<div class="media-body">
									<h5>${board.username}</h5>
									<p>${board.createDate}</p>
								</div>
								<div class="d-flex">
									<img src="/blog/img/blog/user-img.jpg" alt="">
								</div>
							</div>
						</div>
					</div>
					<p>${board.content}</p>

					<div class="news_d_footer">
						<a href="#"><i class="lnr lnr lnr-heart"></i>Lily and 4 people like this</a> <a class="justify-content-center ml-auto" href="#"><i class="lnr lnr lnr-bubble"></i>06 Comments</a>
						<div class="news_socail ml-auto">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-youtube-play"></i></a> <a href="#"><i class="fa fa-pinterest"></i></a> <a
								href="#"><i class="fa fa-rss"></i></a>
						</div>
					</div>
				</div>

				<div class="comments-area">
					<div class="comment-list">
						<div class="single-comment justify-content-between d-flex">
							<div class="user justify-content-between d-flex">
								<div class="thumb">
									<img src="/blog/img/blog/c1.jpg" alt="">
								</div>
								<div class="desc">
									<h5>
										<a href="#">Emilly Blunt</a>
									</h5>
									<p class="date">December 4, 2017 at 3:12 pm</p>
									<p class="comment">Never say goodbye till the end comes!</p>
								</div>
							</div>

						</div>
					</div>
				</div>

				<div class="comment-form">
					<h4>Leave a Reply</h4>
					<form>

						<div class="form-group">
							<textarea class="form-control mb-10" rows="2" name="message" placeholder="Messege" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'" required=""></textarea>
						</div>
						<button class="primary-btn submit_btn" type="submit">Post Comment</button>
					</form>
				</div>
			</div>
			<div class="col-lg-2"></div>
		</div>
	</div>
</section>
<!--================Blog Area =================-->

<%@ include file="/include/footer.jsp"%>
