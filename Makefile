project = bezmen

.PHONY: deps-install install-deps
deps-install install-deps:
	cat requirements/system.reqs | xargs sudo apt -y install
	pip install --user -r requirements/pip.reqs

.PHONY: %-build build-%
%-build build-%:
	@mvn -f $*/pom.xml package

.PHONY: %-install install-%
%-install install-%:
	@mvn -f $*/pom.xml install

.PHONY: %-run run-%
%-run run-%:
	@mvn -f $*/pom.xml docker:start

.PHONY: %-app-run run-%-app
%-app-run run-%-app:
	@mvn -f apps/$*/pom.xml docker:start

.PHONY: unit-tests-run run-unit-tests
unit-tests-run run-unit-tests:
	@mvn -f libs/pom.xml test
	@mvn -f apps/pom.xml test

.PHONY: %-tests-run run-%-tests
%-tests-run run-%-tests:
	@mvn -f tests/$*/pom.xml test

.PHONY: all-tests-run run-all-tests
all-tests-run run-all-tests:
	@mvn -f libs/pom.xml test
	@mvn -f apps/pom.xml test
	@mvn -f tests/pom.xml test

.PHONY: %-stand-deploy deploy-%-stand
%-stand-deploy deploy-%-stand:
	@docker-compose \
	--project-directory stands/$* \
	-p $* \
	up

.PHONY: %-publish publish-%
%-publish publish-%:
	@mvn -f $*/pom.xml deploy
