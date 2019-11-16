/**
 * Created by Anil Kumal on 2/12/2018.
 */
export class ApiConstant {

  public static ROOT_URL = 'http://localhost:4200';
  public static API_ROOT_URL: string = 'http://localhost:8080';
  public static API_ADMIN_ROOT_URL: string = 'http://localhost:8080/api';

  public static BASE_API: string = ApiConstant.API_ROOT_URL + '/api';
  public static NATIO: string = '/natio';
  public static IMAGE_DISPLAY: string = ApiConstant.BASE_API + ApiConstant.NATIO + "/display/";


}
