package com.example.demo

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import spock.lang.Specification

@SpringBootTest
class SpockDemoApplicationSpec extends Specification {

	def "ContextLoads"() {
		when:
		def bool = true;
		then:
		bool == true;
	}
}
