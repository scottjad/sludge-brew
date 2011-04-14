;; ## Core View
;; Standard page layout
(ns sludge-brew.views.core
  (:use [hiccup core page-helpers]))

(defn html-doc [title & body]
    (html
     (doctype :html4)
     [:html
      [:head
       [:title title]
       (include-js "http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js")
       (include-js "http://jashkenas.github.com/coffee-script/extras/coffee-script.js")
       [:script {:type "text/coffeescript"}
	"show_message = (msg) ->
	  $('#message').hide().text(msg).fadeIn(2222,
	    -> $('#message').append('!')
	  )
 
	$ -> show_message \"world\"
	$('#message').click -> show_message \"you\""]]
      [:body
       body]]))