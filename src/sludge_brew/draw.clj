(ns sludge-brew.draw
  (:use slice.core))

(slice draw
  (js (fn coffee-draw [p5]
        (set! p5.setup (fn []
                         (p5.size (.width ($ window))
                                  (.height ($ window)))
                         (p5.background 0)
                         (set! @beans []))

              p5.draw (fn []
                        (var x-off (* p5.frame-count 0.0003)
                             y-off (+ x-off 20)
                             x (* (p5.noise x-off) p5.width)
                             y (* (p5.noise y-off) p5.height))

                        (if (zero? (mod p5.frameCount 8))
                          (var bean (Bean. p5 {:x x :y y :x-off x-off :y-off y-off}))
                          (@bean.push bean))
                        (doseq [bean @beans]
                          (bean.draw)))))
      ;; I don't actually know OO js so this rough approximation
      (fn Bean [p5 opts]
        (set! @p5 p5
              @opts opts
              @x opts.x
              @y opts.y

              @x-off opts.x-off
              @y-off opts.y-off
              @vel (or opts.vel 3)
              @accel (or opts.accel -0.003)

              @draw (fn []
                          (if (pos? @vel)
                            (return))
                          (+= @x-off 0.0007)
                          (+= @y-off 0.0007)
                          (+= @vel @accel)
                          (+= @x (* (@p5.noise @x-off) (- @vel (/ @vel 2))))
                          (+= @y (* (@p5.noise @y-off) (- @vel (/ @vel 2))))
                          (@set-color)
                          (@p5.point @x @y))

              @set-color (fn []
                               (@p5.colorMode @p5.HSB 360 100 100)

                               (var x (@p5.noise (* (/ (+ @x-off @y-off) 2) 360))
                                    s 100
                                    b 100
                                    a 4)

                               (@p5.stroke h s b a)))))
  (dom (var canvas ($ "#processing")
            processing (Processing. canvas coffee-draw))))

;; features assumed but not currently existing
;; zero?/pos? (scriptjure/clojure no, easily added to both)
;; = alised to === (scriptjure)
;; convert keywords (not just symbols) :x-off to :x_off or :xOff or whatever (scriptjure no)
;; @foo shortcut for this.foo (scriptjure/clojurejs no, easy to add)

;; would be nice to have, not used in code above
;; let instead of var (clojurejs yes, clojure no)
;; impicit return (clojurejs yes, scriptjure no)
;; defn (clojurejs yes, scriptjure no)

;; classes (scriptjure/clojurejs no)
