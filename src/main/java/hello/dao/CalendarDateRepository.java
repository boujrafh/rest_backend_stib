package hello.dao;

import hello.model.CalendarDate;
import org.springframework.stereotype.Component;

import javax.ejb.Stateless;

@Component
@Stateless
public class CalendarDateRepository extends RepositoryImpl<CalendarDate> {}