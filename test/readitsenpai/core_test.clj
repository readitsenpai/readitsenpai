(ns readitsenpai.core-test
  (:require [clojure.test :refer :all]
            [readitsenpai.core :refer :all]))

(deftest capitalize-test
  (testing "capitalize"
    (testing "works on single word"
      (is (= (capitalize "andrei") "Andrei")))
    (testing "is idempotent"
      (is (= (capitalize (capitalize "andrei"))
             (capitalize "andrei"))))
    (testing "works on multiple words"
      (is (= (capitalize "hello world")
             "Hello World")))))

(deftest words-test
  (testing "empty string"
    (is (= (words "") [])))
  (testing "simple string"
    (is (= (words "hello world") ["hello" "world"])))
  (testing "simple string with extra spaces"
    (is (= (words "   hello    world    ") ["hello" "world"])))
  (testing "string with only spaces"
    (is (= (words "     ") []))))