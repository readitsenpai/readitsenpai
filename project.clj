(defproject readitsenpai "0.0.1"
  :main ^:skip-aot readitsenpai.core
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [ring "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [hiccup "1.0.5"]
                 [compojure "1.6.0"]]
  :plugins [[lein-cljsbuild "1.1.7"]]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src-cljs"]
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :profiles {:uberjar {:aot :all}})


