function movePage(page) {
	const data = {
        page 
    };
	
	$.ajax(pager_url, {
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        data: data,
        success: result => {
            const {list, pager} = result;
	
		   if(list && list.length > 0) {
				$(`${pager_root}.empty_msg`).addClass("hide");
				
				const tbody = $("<tbody>");  //$(`${pager_root} > tbody`);

		   	let html = "";
          	 for(let i=0; i < result.length; i++) {
                const {code, name, spec, manufacture, category, price} = result[i];
            
            html += `<tr>`;
			html += `<td>${code}</td><td>${name}</td><td>${spec}</td><td>${manufacture}</td><td>${category}</td><td>${price}</td>`;
			html += `<td><div class="btn btn-sm btn-danger">삭제</div> <div class="btn btn-sm btn-warning">변경</div></td>`;
			html += `</tr>`;
           }

           tbody.append(html);

			$(`${pager_root} > tbody`).remove();
			$(`${pager_root}`).append(tbody);

			$(`${pager_root} .page-prev`).data("page", pager.prev);
			$(`${pager_root} .page-next`).data("page", pager.next);
			$(`${pager_root} .page-last`).data("page", pager.last);
			
			}      
        },
        error: xhr => {
            alert(`오류 발생: ${xhr.stausText}`);
        }
    });
}

$(function() {
	movePage(10);
	
	$(`${pager_root} .page_link`).click(function() {
		const page = $(this).data("page");
		
		movePage(page);
	});
}) ;





