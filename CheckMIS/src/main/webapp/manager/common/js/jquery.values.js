/* jQuery.values: get or set all of the name/value pairs from child input controls
 * based on http://stackoverflow.com/a/1490431/.
 * @argument data {array} If included, will populate all child controls.
 * @returns element if data was provided, or array of values if not
*/
$.fn.values = function(data) {
    var form = $(this);

    if(typeof data != 'object') {
        var els = $(':input:not(:disabled)', form).get();
        // return all data
        var data = {};

        $.each(els, function() {
            //data[this.name]== '';
                switch (this.nodeName.toLowerCase()) {
                    case "input":
                        switch (this.type) {
                            case "radio":
                                if (typeof data[this.name] == 'undefined') {
                                    data[this.name] = '';
                                }
                                if (this.checked) {
                                    data[this.name]= this.value || '';;
                                }
                                break;
                            case "checkbox":
                                if (typeof data[this.name] == 'undefined') {
                                    data[this.name] = [];
                                }
                                if (this.checked) {
                                    data[this.name].push(this.value || '');
                                }
                                break;
                            default:
                                data[this.name] = this.value || '';
                                break;
                        }
                        break;
                    case "select":
                    case "textarea":
                        data[this.name] = this.value || '';
                        break;
                }
        });
        return data;
    } else {
        if(!data){
            return $(form).serialize();
        }
    	var els = $(':input:not(:button)', form).get();
    	
    	$.each(els, function() {
    		if(!this.name){
    			return true;
    		}
    		try{
    			var value=eval("data."+this.name);
    			let notempty=false;
                if(value||value==0){
                    notempty=true;
                }else{
                    value="";
                }
                let setV=true;
                switch (this.nodeName.toLowerCase()) {
                    case "input":
                        switch (this.type) {
                            case "radio":
                            case "checkbox":
                                if(this.value==value){
                                    this.checked=true;
                                }
                                setV=false;
                                break;
                        }
                        break;
                    case "select":
                        $(this).attr('defaultValue', value);$(this).trigger('change');
                        break;
                    default:
                        break;
                }
                if(setV){
                    this.value = value;
                }

    		}
    		catch(e){console.log(e)}
    		
    	});
    	
        /*$.each(data, function(key, value){
        	var input = $(':input[name='+key+']', form);
        	input.val(value);
        	if(input[0])
	        	switch (input[0].tagName) {
	        	 case "SELECT":input.attr('defaultValue', value);input.trigger('change')
	        	}
        });*/
        return $(form);
    }
};

