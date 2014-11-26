		/*!
		 * jQuery Quiz plugin 
		 * Original author: @velmurugan
		 * Further changes, comments: @velmurugan
		 * Licensed under the Apache V2 license
		 */
		// the semi-colon before the function invocation is a safety
		// net against concatenated scripts and/or other plugins
		// that are not closed properly.
		;
		(function($, window, document, undefined) {

		    // undefined is used here as the undefined global
		    // variable in ECMAScript 3 and is mutable (i.e. it can
		    // be changed by someone else). undefined isn't really
		    // being passed in so we can ensure that its value is
		    // truly undefined. In ES5, undefined can no longer be
		    // modified.

		    // window and document are passed through as local
		    // variables rather than as globals, because this (slightly)
		    // quickens the resolution process and can be more
		    // efficiently minified (especially when both are
		    // regularly referenced in your plugin).

		    // Create the defaults once
		    var pluginName = "jBootQuiz"



		    // Common functions
		    function pad(number, length) {
		        var str = '' + number;
		        while (str.length < length) {
		            str = '0' + str;
		        }
		        return str;
		    }

		    function formatTime(time) {
		        var min = parseInt(time / 6000),
		            sec = parseInt(time / 100) - (min * 60),
		            hundredths = pad(time - (sec * 100) - (min * 6000), 2);
		        return (min > 0 ? pad(min, 2) : "00") + ":" + pad(sec, 2) + ":" + hundredths;
		    }

		    // The actual plugin constructor

		    function Plugin(element, options) {
		        this.element = element;

		        // jQuery has an extend method that merges the
		        // contents of two or more objects, storing the
		        // result in the first object. The first object
		        // is generally empty because we don't want to alter
		        // the default options for future instances of the plugin
		        this.options = options;
		        this._defaults = options;
		        this._name = pluginName;
		        this.init();
		    }

		    Plugin.defaults = {

		        url: "http://localhost:8080/certifier/exam/data",

		        params: {
		            limit: 1,
		            offset: 0,
		            order: "asc"
		        },
		        method: 'get',

		        contentType: 'application/json',

		        dataType: 'json',

		        enableTimer: true,

		        timerSettings: {
		            durationPerQuestion: 15000,
		            totalTime: 1800000, // Total Timer time , by default this value will be 
		            incrementTime: 100 // count down change every second
		        },

		        data: {},

		        /*{

				   "totalQ":"60",
				   "q": "What number is the letter A in the English alphabet?",
				   "a": [
						{"option": "8",      "checked": false},
						{"option": "14",     "checked": false},
						{"option": "1",      "checked": false},
						{"option": "23",     "checked": false}
				]
			} */
		    }



		    Plugin.events = {

		        onNext: 'onNext',
		        onNext: 'onPrevious',
		        onNext: 'onReview',
		        onNext: 'onComplete'

		    }
		    Plugin.prototype = {

		        init: function() {
		            // Place initialization logic here
		            // You already have access to the DOM element and
		            // the options via the instance, e.g. this.element
		            // and this.options
		            // you can add more functions like the one below and
		            // call them like so: this.yourOtherFunction(this.element, this.options).
		            this.options = $.extend({}, this.options, Plugin.defaults);
		            this.$container = $(['<div class="container">',
		                '<div class="row">',
		                '<div class="col-md-3">Question ',
		                '<div class="btn-group">',
		                '<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">',
		                '<span class="j-boot-quiz-current-question-no">1</span>  <span class="caret"></span>',
		                '</button>',
		                '<ul class="dropdown-menu scrollable-menu j-boot-quiz-dropdown-menu" role="menu">',
		                '</ul>',
		                '</div>',
		                '<span> of </span> <span class="j-boot-quiz-total-no-of-question">60</span></div>',
						'<div class="col-md-3">',
						'<div class="checkbox">',
      					'<label>',
        				'<input class= "j-boot-quiz-mark-for-review" type="checkbox" value="">',
        				'Mark for review',
						'</label>',
    					'</div>',
						'</div>',
		                '<div class="col-md-offset-3 col-md-3">',
		                '<button type="button" id="playButton" data-btnstate="Pause" class="btn btn-primary j-boot-quiz-play-btn" 																		autocomplete="off">', 'Play/Pause',
		                '</button>',
		                '<span class="j-boot-quiz-timer"> Timer will be placed here: </span></div>',
		                '</div>',
		                '<div class="row">',
		                '<h4 class="j-boot-quiz-question" >  </h4>',
		                '</div>',
		                ' <div class="row j-boot-quiz-options"> ',

		                '  </div>',
		                ' <div class="row">',
		                '<div class="progress j-boot-quiz-progress">',
		                '<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">',
		                '<span class="sr-only">Loading next Question !</span>',
		                ' </div>',
		                '</div>',
		                ' </div>',

		                '<div class="row">',
		                '<div class="btn-group btn-group-justified" role="group" aria-label="...">',
		                '<div class="btn-group" role="group">',
		                '<button type="button" class="btn btn-default j-boot-quiz-previous" data-index="-1" disabled="disabled" >  <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span> Previous</button>',
		                ' </div>',
		                '<div class="btn-group" role="group">',
		                '<button type="button" class="btn btn-default j-boot-quiz-next" data-index="1">  <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span> Next</button>',
		                '</div>',
		                '<div class="btn-group" role="group">',
		                '<button type="button" data-toggle="modal" data-target="#reviewModal" class="btn btn-default j-boot-quiz-review"> <span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span> Review</button>',
		                ' </div>',
		                ' <div class="btn-group" role="group">',
		                '<button type="button" class="btn btn-default j-boot-quiz-complete">',
		                '<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>',
		                'Complete</button>',
		                ' </div>',
		                '</div>',
		                ' </div>',
					    
					    '<div id="reviewModal" class="modal fade" tabindex="-1" role="dialog">',
						'<div class="modal-dialog modal-lg">',
						'<div class="modal-content">',
						'<div class="modal-header">',
						'<button type="button" class="close" data-dismiss="modal">×</button>',
						'<h3>Modal header</h3>',
						'</div>',
						'<div class="modal-body">',
						'<table data-pagination="true" data-search=true  data-click-to-select=true data-select-item-name="radioName" class="j-boot-quiz-review-table">',
    					'<thead>',
    					'<tr>',
        				'<th data-field="totalQ" data-radio="true" >Name</th>',
        				'<th data-field="q">Stars</th>',
        				'<th data-field="a">Forks</th>',
						'</tr>',
						'</thead>',
						'</table>',
						'</div>',
						'<div class="modal-footer">',
						'<button class="btn" data-dismiss="modal">Close</button>',
						'</div>',
						'</div>',
						'</div>',	
						'</div>',
										
		                '</div>'
		            ].join(''))

		            $(this.element).append(this.$container);
		            $('.j-boot-quiz-progress').hide();
		            this.$questionDiv = this.$container.find('.j-boot-quiz-question');
		            this.$questionDiv.text(this.options.data.q);
		            this.$optionDiv = this.$container.find('.j-boot-quiz-options');
		            this.$container.data({
		                "cache": []
		            });
		            this.$currentQ = this.$container.find('.j-boot-quiz-current-question-no');
		            this.$currentQ.text("1").data('index', 0)
		            this.$previousBtn = this.$container.find('.j-boot-quiz-previous');
		            this.$previousBtn.data('index', -1);
		            this.$nextBtn = this.$container.find('.j-boot-quiz-next');
		            this.$nextBtn.data('index', 1);
		            this.$playBtn = this.$container.find('.j-boot-quiz-play-btn');
		            this.$questionList = this.$container.find('.j-boot-quiz-dropdown-menu a');
					this.$markForReview = this.$container.find('.j-boot-quiz-mark-for-review');
					

		            $reviewBtn = this.$container.find('.j-boot-quiz-review')
		            $completeBtn = this.$container.find('.j-boot-quiz-complete')
		            this.$previousBtn.off().on("click", $.proxy(this.previous, this))
		            this.$nextBtn.off().on("click", $.proxy(this.next, this))
//		            $reviewBtn.off().on("click", $.proxy(this.review, this))
		            $completeBtn.off().on("click", $.proxy(this.complete, this))
		            this.$playBtn.off().on("click", $.proxy(this.playPauseTimer, this))
					this.$markForReview.off().on("click", $.proxy(this.markForReview, this))
					this.$container.find('#reviewModal').off().on('show.bs.modal',$.proxy(this.review, this))
		            this.fetchFromServer();
		        },
		        initQuizHeader: function() {

		        },
		        initButtons: function() {

		        },
		        initQuizBody: function() {

		        },
				initReviewModal:function(){
					
				},
		        next: function(event) {
		            $that = this;
		            this.$questionDiv.text(this.options.data.q);
		            nextIndex = $(event.currentTarget).data('index')
		            currentIndex = this.$currentQ.data('index')
		            prevIndex = this.$previousBtn.data('index')

		            console.log('index value of previous , current , next ' + prevIndex + ' ,' + currentIndex + ' ,' + nextIndex);

		            $(":checkbox").each(function(i, option) {
		                if ($(this).prop('checked')) {
		                    console.log(i, 'checked')
		                    $that.options.data.a[$(option).data('id')].checked = true;
		                }
		            })
		            this.$container.data("cache")[currentIndex] = this.options.data
		            console.log('current cache value is : ' + this.$container.data("cache"));
		            this.$previousBtn.data('index', currentIndex);
		            this.$currentQ.data('index', nextIndex)
		            $(event.currentTarget).data('index', nextIndex + 1)
		            if (nextIndex >= this.$container.data("cache").length) {
		                this.fetchFromServer();
		            } else
		                this.loadQuestion(this.$container.data("cache")[nextIndex])
		                //this.fetchFromServer();	
		            if (this.$currentQ.data('index') >= 1) {
		                if (this.$previousBtn.attr('disabled'))
		                    this.$previousBtn.removeAttr('disabled');
		                else {}

		            }
		        },

		        previous: function(event) {
		            $that = this;
		            prevIndex = $(event.currentTarget).data('index')
		            nextIndex = this.$nextBtn.data('index')
		            currentIndex = this.$currentQ.data('index')
		            console.log('index value of previous , current , next ' + prevIndex + ' ,' + currentIndex + ' ,' + nextIndex);
		            $that.$optionDiv.empty();
		            this.loadQuestion(this.$container.data("cache")[prevIndex])
		            $(event.currentTarget).data('index', prevIndex - 1)
		            this.$currentQ.data('index', prevIndex)
		            this.$nextBtn.data('index', currentIndex)
		            if (this.$currentQ.data('index') == 0) {
		                if (this.$previousBtn.attr('disabled')) {} else
		                    this.$previousBtn.attr('disabled', 'disabled');
		            }
		        },

		        //next question ajax will come here: 
		        fetchFromServer: function() {
		            $that = this
		            $('.j-boot-quiz-progress').show();

		            $.ajax({
		                type: this.options.method,
		                url: this.options.url,
		                data: this.options.params,
		                contentType: this.options.contentType,
		                dataType: this.options.dataType,
		                success: function(res) {
		                    $that.options.data = res
		                    $that.loadQuestion();
		                    $that.initTimer();
		                    $that.initQuestionList();
		                },
		                error: function(res) {
		                    console.log('Error occured: ' + res);
		                },
		                complete: function() {
		                    $('.j-boot-quiz-progress').hide();
		                }
		            });
		        },

		        loadQuestion: function(option) {

		            $that = this
		            if (option) {
		                this.options.data = option
		            }
		            this.$optionDiv.empty();
		            this.$container.find('.j-boot-quiz-total-no-of-question').text(this.options.data.totalQ);
		            this.$currentQ.text(this.$currentQ.data('index') + 1);
		            $.each(this.options.data.a, function(i, option) {
		                $optionHtml = $(['<div class="checkbox">',
		                    ' <label>',
		                    '<input id="', i, '"type="checkbox" value=""  data-id=', i, '>',
		                    option.option,
		                    '  </label>',
		                    '</div>'
		                ].join(''));
		                $that.$optionDiv.append($optionHtml);
		                if (option.checked) {
		                    $('#' + i).prop("checked", true);
						}
		            })
		        },

		        review: function(el) {	
					$that=this
					var data = this.$container.data('cache');
					if(this.$container.find('.j-boot-quiz-review-table').data('bootstrap.table')){
						this.$container.find('.j-boot-quiz-review-table').bootstrapTable('destroy');
					}
				    this.$container.find('.j-boot-quiz-review-table').bootstrapTable({data:data})
//					.off().on('click-row.bs.table', function (e, row, $element) {
//							alert('Event: click-row.bs.table, data: ' + JSON.stringify(row));
//            			}).
					
					.off().on('dbl-click-row.bs.table', function (e, row, $element) {
							//alert('Event: dbl-click-row.bs.table, data: ' + JSON.stringify(row));
							$that.$container.find('#reviewModal').modal('hide');
						})
					 
		        },
		        complete: function(el) {
		            if(confirm('Are you sure to complete the exam ? '))
					{
						this.$container.find('#reviewModal').modal('show');
					}
		        },
		        initTimer: function() {
		            if (!$('.j-boot-quiz-timer').data('timer') && this.options.enableTimer) {
		                currentTime = this.options.timerSettings.durationPerQuestion * this.options.data.totalQ
		                incrementTime = this.options.timerSettings.incrementTime;
		                this.updateTimer = function() {
		                    $('.j-boot-quiz-timer').html(formatTime(currentTime));
		                    if (currentTime == 0) {
		                        timer.stop();
		                        alert('time up ! ');
		                        return;
		                    }
		                    currentTime -= incrementTime / 10;
		                    if (currentTime < 0) currentTime = 0;
		                }

		                timer = this.timer(this.updateTimer, incrementTime, true);
		                $('.j-boot-quiz-timer').data('timer', timer);
		            }
		        },
		        initQuestionList: function() {
		            if (!$('.j-boot-quiz-dropdown-menu').data('initialized')) {
		                html = [];
		                for (i = 0; i < this.options.data.totalQ; i++) {
		                    html.push('<li><a href="javascript:void(0)">');
		                    html.push(i + 1);
		                    html.push('</a></li>')
		                }
		                this.$container.find('.j-boot-quiz-dropdown-menu').append(html.join(''));
		                this.$questionList = this.$container.find('.j-boot-quiz-dropdown-menu a');
		                this.$questionList.off().on("click", $.proxy(this.questionListChange, this))
		                $('.j-boot-quiz-dropdown-menu').data('initialized', true)
		            }

		        },
		        questionListChange: function(event) {

		            var $this = $(event.currentTarget);
		            $this.parent().addClass('active').siblings().removeClass('active');
		            this.$currentQ.text($this.text());


		        },
				markForReview:function(event){
					alert('question marked for review');
				},
		        playPauseTimer: function() {

		            if (this.$playBtn.data('btnstate') === "Pause") {
		                $('.j-boot-quiz-timer').data('timer').pause();
		                this.$playBtn.data('btnstate', 'Play');
		            } else {
		                $('.j-boot-quiz-timer').data('timer').play(true);
		                this.$playBtn.data('btnstate', 'Pause');
		            }

		        },
		        timer: function(func, time, autostart) {

		            this.set = function(func, time, autostart) {
		                this.init = true;
		                if (typeof func == 'object') {
		                    var paramList = ['autostart', 'time'];
		                    for (var arg in paramList) {
		                        if (func[paramList[arg]] != undefined) {
		                            eval(paramList[arg] + " = func[paramList[arg]]");
		                        }
		                    };
		                    func = func.action;
		                }
		                if (typeof func == 'function') {
		                    this.action = func;
		                }
		                if (!isNaN(time)) {
		                    this.intervalTime = time;
		                }
		                if (autostart && !this.isActive) {
		                    this.isActive = true;
		                    this.setTimer();
		                }
		                return this;
		            };
		            this.once = function(time) {
		                var timer = this;
		                if (isNaN(time)) {
		                    time = 0;
		                }
		                window.setTimeout(function() {
		                    timer.action();
		                }, time);
		                return this;
		            };
		            this.play = function(reset) {
		                if (!this.isActive) {
		                    if (reset) {
		                        this.setTimer();
		                    } else {
		                        this.setTimer(this.remaining);
		                    }
		                    this.isActive = true;
		                }
		                return this;
		            };
		            this.pause = function() {
		                if (this.isActive) {
		                    this.isActive = false;
		                    this.remaining -= new Date() - this.last;
		                    this.clearTimer();
		                }
		                return this;
		            };
		            this.stop = function() {
		                this.isActive = false;
		                this.remaining = this.intervalTime;
		                this.clearTimer();
		                return this;
		            };
		            this.toggle = function(reset) {
		                if (this.isActive) {
		                    this.pause();
		                } else if (reset) {
		                    this.play(true);
		                } else {
		                    this.play();
		                }
		                return this;
		            };
		            this.reset = function() {
		                this.isActive = false;
		                this.play(true);
		                return this;
		            };
		            this.clearTimer = function() {
		                window.clearTimeout(this.timeoutObject);
		            };
		            this.setTimer = function(time) {
		                var timer = this;
		                if (typeof this.action != 'function') {
		                    return;
		                }
		                if (isNaN(time)) {
		                    time = this.intervalTime;
		                }
		                this.remaining = time;
		                this.last = new Date();
		                this.clearTimer();
		                this.timeoutObject = window.setTimeout(function() {
		                    timer.go();
		                }, time);
		            };
		            this.go = function() {
		                if (this.isActive) {
		                    this.action();
		                    this.setTimer();
		                }
		            };
		            this.set(func, time, autostart);
		            return this;
		        }
		    };

		    // A really lightweight plugin wrapper around the constructor,
		    // preventing against multiple instantiations
		    $.fn[pluginName] = function(options) {
		        return this.each(function() {
		            if (!$.data(this, "plugin_" + pluginName)) {
		                $.data(this, "plugin_" + pluginName,
		                    new Plugin(this, options));
		            }
		        });
		    };
		    $(function() {
		        $('[data-toggle="jbootquiz"]').jBootQuiz()
		    })
		})(jQuery, window, document);