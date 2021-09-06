ifeq ($(shell uname -s),Windows)
	RUN_MVN = ./mvnw.cmd
else
	RUN_MVN = ./mvnw
endif

package:
	$(RUN_MVN) -DskipTests=true package
build: package

test:
	$(RUN_MVN) clean test

.PHONY: package build test
