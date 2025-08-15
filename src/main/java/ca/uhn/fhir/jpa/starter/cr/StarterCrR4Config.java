package ca.uhn.fhir.jpa.starter.cr;

import ca.uhn.fhir.jpa.starter.annotations.OnR4Condition;
import org.opencds.cqf.fhir.cr.hapi.config.r4.ApplyOperationConfig;
import org.opencds.cqf.fhir.cr.hapi.config.r4.CrR4Config;
import org.opencds.cqf.fhir.cr.hapi.config.r4.DataRequirementsOperationConfig;
import org.opencds.cqf.fhir.cr.hapi.config.r4.EvaluateOperationConfig;
import org.opencds.cqf.fhir.cr.hapi.config.r4.ExtractOperationConfig;
import org.opencds.cqf.fhir.cr.hapi.config.r4.PackageOperationConfig;
import org.opencds.cqf.fhir.cr.hapi.config.r4.PopulateOperationConfig;
import org.opencds.cqf.fhir.cr.hapi.config.r4.QuestionnaireOperationConfig;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.opencds.cqf.fhir.cr.measure.MeasureEvaluationOptions;
import org.opencds.cqf.fhir.cql.EvaluationSettings;

@Configuration
@Conditional({OnR4Condition.class, CrConfigCondition.class})
@Import({
	CrCommonConfig.class,
	CrR4Config.class,
	ApplyOperationConfig.class,
	DataRequirementsOperationConfig.class,
	EvaluateOperationConfig.class,
	ExtractOperationConfig.class,
	PackageOperationConfig.class,
	PopulateOperationConfig.class,
	QuestionnaireOperationConfig.class
})
public class StarterCrR4Config {
	@Bean
	public MeasureEvaluationOptions measureEvaluationOptions() {
		return MeasureEvaluationOptions.defaultOptions();
	}

	@Bean
	public EvaluationSettings evaluationSettings() {
		return EvaluationSettings.getDefault();
	}
}
