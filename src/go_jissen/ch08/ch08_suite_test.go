package main_test

import (
	"testing"

	. "github.com/onsi/ginkgo"
	. "github.com/onsi/gomega"
)

func TestCh08(t *testing.T) {
	RegisterFailHandler(Fail)
	RunSpecs(t, "Ch08 Suite")
}
