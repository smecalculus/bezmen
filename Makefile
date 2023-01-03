project:=bezmen

deps-install install-deps:
	cat requirements/ubuntu.reqs | xargs sudo apt -y install
	pip install --user -r requirements/pip.reqs
.PHONY: deps-install install-deps

%-build build-%:
	@mvn -f $*/pom.xml package
.PHONY: %-build build-%

%-install install-%:
	@mvn -f $*/pom.xml install
.PHONY: %-install install-%

%-start start-%:
	@mvn -f $*/pom.xml docker:start
.PHONY: %-start start-%

%-app-start start-%-app:
	@mvn -f app/$*/pom.xml docker:start
.PHONY: %-app-start start-%-app

# TESTING

unit-test:
	@mvn -f app/pom.xml test
.PHONY: unit-test

%-unit-test:
	@mvn -f app/pom.xml test -am -pl $*
.PHONY: %-unit-test

%-test :
	@mvn -f test/$*/pom.xml test
.PHONY: %-test

all-test: unit-test
	@mvn -f test/pom.xml test
.PHONY: all-test

db:=postgres

#.PHONY: %-stand-deploy deploy-%-stand
#%-stand-deploy deploy-%-stand:
#	docker-compose \
#		-f stand/compose/$*.yml \
#		-p $* \
#		--profile db:$(db) \
#		up

%-stand-deploy deploy-%-stand:
	cd stand/ansible && \
	ansible-playbook $*.yml \
		-i inventory/$* \
		-e db=$(db)
.PHONY: %-stand-deploy deploy-%-stand

%-publish publish-%:
	@mvn -f $*/pom.xml deploy
.PHONY: %-publish publish-%
