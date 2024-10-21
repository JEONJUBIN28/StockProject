console.log("notice 모듈..");

let noticeService = function() {

	function noticeList(callback) {

		$.ajax({

			type: "GET",
			url: "/board/notice",
			success: function(result) {
				console.log(result);
				if(callback){
					callback(result);
				}
			},
			error: function(e) {
				console.log(e);
			}

		});

	}
	
	function getNotice(notice_id, callback) {

			$.ajax({

				type: "GET",
				url: "/board/notice/" + notice_id,
				success: function(result) {
					console.log(result);
					if(callback){
						callback(result);
					}
				},
				error: function(e) {
					console.log(e);
				}

			});

		}

	function write(notice) {

		$.ajax({

			type: "POST",
			url: "/board/notice/create",
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(notice),
			success: function(result) {

				if (result == "SUCCESS")
					console.log(result);

			},
			error: function(e) {
				console.log(e);
			}

		});

	}
	
	function update(notice) {

			$.ajax({

				type: "PUT",
				url: "/board/notice/update",
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(notice),
				success: function(result) {

					if (result == "SUCCESS")
						console.log(result);

				},
				error: function(e) {
					console.log(e);
				}

			});

		}

	function del(notice_id) {

		$.ajax({

			type: "DELETE",
			url: "/board/notice/delete/" + notice_id,
			success: function(result) {

				console.log("삭제된 개수 : " + result);

			},
			error: function(e) {
				console.log(e);
			}

		});

	}
	

	return {
		noticeList : noticeList,
		getNotice : getNotice,
		write : write,
		update : update,
		del	: del,
	}

}