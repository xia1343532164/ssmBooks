console.log('book-list');

$('#batch-delete-btn').click(function() {
	console.log('batch-delete-btn');
	var ids = $('input[type="checkbox"]')
		.filter(function() {
			return this.checked; // 只要选中的复选框
		})
		.map(function() {
			return $(this).data('book-id'); // 从复选框上获取data
		});
	if(ids.length ===0){
		console.log('noop');
		return;
	}
	// 为什么不直接ids.join(',') 因为ids不是一个真正的数组
	var idsCsv = Array.prototype.join.call(ids, ','); // 将id数组转换成逗号分隔id的字符串
	
	console.log('ids', idsCsv);
	$('#batch-delete-form input[name="ids"]').val(idsCsv); // 把ids的csv设置到表单input上
	$('#batch-delete-form').submit(); // 提交表单
});