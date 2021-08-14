ifeq ($(shell uname -s),Windows)
	RUN_MVN = ./mvnw.cmd
else
	RUN_MVN = ./mvnw
endif

package:
	$(RUN_MVN) -DskipTests=true clean package

test:
	$(RUN_MVN) clean test
