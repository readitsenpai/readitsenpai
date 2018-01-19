(defproject readitsenpai "0.0.1"
  :main         ^:skip-aot readitsenpai.core
  :dependencies [[org.clojure/clojure     "1.9.0"]
                 [ring/ring-core          "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [hiccup                  "1.0.5"]
                 [compojure               "1.6.0"]]
  :profiles     {:uberjar {:aot :all}})


