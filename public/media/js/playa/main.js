//main logic of the page is here

//binding fade effect of the row text
(function($){
    
    var carouselLength = $('#myCarousel item').length;
    
    //binding the events
    $('#myCarousel').on('slide.bs.carousel', function () {
        var currentRowSetIndex,
            nextRowSetIndex,
            currIndex,
            $currRowSet,
            $nextRowSet;

        currIndex = $('#myCarousel .active').index();
        currentRowSetIndex = currIndex % 2;
        nextRowSetIndex = (currIndex + 1) % 2;
        
        $currRowSet = $('#rowset' + currentRowSetIndex);
        $nextRowSet = $('#rowset' + nextRowSetIndex);
        
        //binding transition end events to source and target
        $currRowSet.on('webkitTransitionEnd', function () {
            var self = $(this);
            //Hide this block
            self.addClass('hidden');
            
            //fade in the next row set
            $nextRowSet.removeClass('hidden');
            //make sure hidden is set before applying opacity change
            setTimeout(function(){$nextRowSet.removeClass('hiddenRow');}, 10);
            
            self.off('webkitTransitionEnd');
        });
        
        //fade out current row set
        $currRowSet.addClass('hiddenRow');
        
    });
})(jQuery);