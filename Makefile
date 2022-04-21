project = bezmen

.PHONY: deps-install install-deps
deps-install install-deps:
	cat requirements/ubuntu.reqs | xargs sudo apt -y install
	pip install --user -r requirements/pip.reqs

.PHONY: %-build build-%
%-build build-%:
	@mvn -f $*/pom.xml package

.PHONY: %-install install-%
%-install install-%:
	@mvn -f $*/pom.xml install

.PHONY: %-start start-%
%-start start-%:
	@mvn -f $*/pom.xml docker:start

.PHONY: %-app-start start-%-app
%-app-start start-%-app:
	@mvn -f apps/$*/pom.xml docker:start

.PHONY: unit-tests-run run-unit-tests
unit-tests-run run-unit-tests:
	@mvn -f libs/pom.xml test
	@mvn -f apps/pom.xml test

.PHONY: %-tests-run run-%-tests
%-tests-run run-%-tests:
	@mvn -f tests/$*/pom.xml test

.PHONY: all-tests-run run-all-tests
all-tests-run run-all-tests: unit-tests-run
	@mvn -f tests/pom.xml test

db=postgres

.PHONY: %-stand-deploy deploy-%-stand
%-stand-deploy deploy-%-stand:
	@docker-compose \
	-p $* \
	-f stand/compose/$*.yml \
	--profile db:$(db) \
	up

#.PHONY: %-stand-deploy deploy-%-stand
#%-stand-deploy deploy-%-stand:
#	@ansible-playbook \
#	stand/ansible/$*.yml \
#	-i stand/ansible/inventory/$* \
#	-e db=$(db)

#.PHONY: %-stand-deploy deploy-%-stand
#%-stand-deploy deploy-%-stand:
#	@ansible-playbook \
#	stand/ansible/$*/playbook.yml \
#	-i stand/ansible/$*/hosts \
#	-e db=$(db)

.PHONY: %-publish publish-%
%-publish publish-%:
	@mvn -f $*/pom.xml deploy
