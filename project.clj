(defproject tika-server "1.0.0-SNAPSHOT"
  :description "listen on port 9998 and pass work to Tika"
  :dev-dependencies [[org.clojure/tools.nrepl "0.2.2"]]
  :dependencies [[org.clojure/clojure "1.5.0"]
                 [clj-tika "1.2.0"]
                 [ring-server "0.2.8"]
                 [cheshire "5.0.2"]]
                  ;[ring/ring-core "1.1.6"]]
  :main "tika-server.core")
