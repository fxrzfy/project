$(document).ready(function () {
    var myPlaylist = new jPlayerPlaylist({
            jPlayer: "#jplayer_N",
            cssSelectorAncestor: "#jp_container_N"
        }, [],
        {
            playlistOptions: {
                enableRemoveControls: true,
                autoPlay: false
            },
            swfPath: "js/jPlayer",
            supplied: "webmv, ogv, m4v, oga, mp3",
            useStateClassSkin: true,
            autoBlur: false,
            smoothPlayBar: true,
            keyEnabled: true,
            audioFullScreen: false
        });
    var latest = [];

    var spirit = [];
    $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer, function () {//$(document).on('click','要选择的元素',function(){})  on方法包含很多事件，点击，双击等等事件。
        $('.musicbar').removeClass('animate'); //look this class and remove it
        $('.jp-play-me').removeClass('active');
        $('.jp-play-me').parent('li').removeClass('active');
    });

    $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer, function () {
        $('.musicbar').addClass('animate');// when the player add a animate
    });
    $("#before,#after").addClass("set_imd");

    $(document).on('click', '.jp-play-me', function (e) {
        e && e.preventDefault();
        var $this = $(e.target);
        if (!$this.is('a')) $this = $this.closest('a');//closest() 方法获得匹配选择器的第一个祖先元素，从当前元素开始沿 DOM 树向上。
        $('.jp-play-me').not($this).removeClass('active');
        $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');

        $this.toggleClass('active');
        $this.parent('li').toggleClass('active');
        if (!$this.hasClass('active')) {
            myPlaylist.pause();
        } else {
            var k = $(this).parent("li").index();

            $(".poster-img").attr("src", latest[k].poster);//此方法返回一个函数改变src   $('a.cover1').html('<img src="' + latest[k].poster );
            $(".musicbar").addClass("animate").index();
            myPlaylist.add({
                title: latest[k].title,
                artist: latest[k].artist,
                mp3: latest[k].mp3,
                poster: latest[k].poster
            });
            myPlaylist.play(-1);
        }
    });

    $(document).on('click', '.jp-play-fun', function (e) {
        e && e.preventDefault();
        var $this = $(e.target);
        if (!$this.is('a')) $this = $this.closest('a');//closest() 方法获得匹配选择器的第一个祖先元素，从当前元素开始沿 DOM 树向上。
        $('.jp-play-fun').not($this).removeClass('active');
        $('.jp-play-fun').parent('li').not($this.parent('li')).removeClass('active');

        $this.toggleClass('active');
        $this.parent('li').toggleClass('active');
        let audioVbox = $("#audioVbox");
        if(audioVbox.hasClass('hide')){
            audioVbox.removeClass('hide');
        }
        if (!$this.hasClass('active')) {
            myPlaylist.pause();
        } else {
            var k = $(this).parent("li").index();
            var url = $(this).attr('data-url');
            // var url = '{"title": "The 444444 of fortune", "artist": "Yang 44444", "mp3": "http://sobot.oss-cn-beijing.aliyuncs.com/pass/record/96e08460ff1f494ca9b4b89f57508388/8aaf07086436008b0164409261a109a0/20180719/3a86a19d-0a43-4f75-ad81-7c876e2eb896.wav", "poster": "http://p1.music.126.net/4xHOkSVWH-n6p5pB3Jf0yQ==/109951162922204274.jpg?param=130y130" }'
            var spirit = {
                "title":url,
                "artisit":'',
                "mp3":url,
                "poster":''
            }
            // var spirit = JSON.parse(spiritStr);
            // $(".poster-img").attr("src", spirit[k].poster);
            //此方法返回一个函数改变src   $('a.cover1').html('<img src="' + spirit[k].poster );
            myPlaylist.add({
                title: spirit.title,
                artist: spirit.artist,
                mp3: spirit.mp3,
                poster: spirit.poster
            });
            myPlaylist.play(-1);
        }
    });
});
