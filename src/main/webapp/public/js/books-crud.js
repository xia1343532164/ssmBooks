    $("#jsGrid").jsGrid({
        width: "100%",
        height: "400px",

        inserting: true,
        editing: true,
        sorting: true,
        paging: true,

        autoload: true,
        controller: {
        	// 自动加载数据时调用
            loadData: function() {
            	console.log('loading data...');
            	return $.ajax('/ssmBooks/books/', {method: 'GET'});
            },
            insertItem: function(item) {
            	console.log('insert', item);
            	var json = JSON.stringify(item); // 把js对象用json格式转成字符串
            	return $.ajax('/ssmBooks/books/', {
            		method: 'POST',
            		data: json,
            		contentType: 'application/json; charset=UTF-8'
            	});
            },
            updateItem:function(item) {
            	console.log('update', item);
            	var json = JSON.stringify(item); // 把js对象用json格式转成字符串
            	return $.ajax('/ssmBooks/books/'+item.id, {
            		method: 'PUT',
            		data: json,
            		contentType: 'application/json; charset=UTF-8'
            	});
            },   
             deleteItem: function(item) {
            	console.log('delete', item);
            	return $.ajax('/ssmBooks/books/'+item.id, {
            		method: 'DELETE',
            	});
             }
        },
        
        fields: [
            { name: "title", type: "text", width: 150, validate: "required", title: '书名' },
            { name: "author", type: "text", width: 50, title: '作者' },
            { name: "publisher", type: "text", width: 200, title: '出版社' },
            { type: "control" }
        ]
    });
