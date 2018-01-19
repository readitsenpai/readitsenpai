(ns readitsenpai.core-test
  (:require [clojure.test :refer :all]
            [readitsenpai.core :refer :all]))

(deftest capitalize-test
  (testing "capitalize works"
    (is (= (capitalize "kana") "Kana")))
  (testing "capitalize is idempotent"
    (is (= (capitalize (capitalize "kana"))
           (capitalize "kana"))))
  (testing "capitalize multiple words"
    (is (= (capitalize "hello world")
           "Hello World"))))

(deftest words-test
  (testing "empty string"
    (is (= (words "") [])))
  (testing "simple string"
    (is (= (words "hello world") ["hello" "world"])))
  (testing "simple string with extra spaces"
    (is (= (words "   hello    world    ") ["hello" "world"])))
  (testing "string with only spaces"
    (is (= (words "     ") []))))