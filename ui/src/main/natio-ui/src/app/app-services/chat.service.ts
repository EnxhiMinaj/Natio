import {Injectable} from "@angular/core";
import {FTBaseService} from "../core/lib/services/ft-base.service";
import {HttpService} from "../core/lib/services/http.service";


@Injectable()
export class ChatService extends FTBaseService {
  dataModel: {};

  serviceApi: string = '/natio/chat';



  constructor(httpService: HttpService) {
    super(httpService);
  }

  sendMsg(msg) {
    this.httpService.postRequest(this.serviceApi,msg);
  }

  create(data) {
    return this.httpService.postRequest(this.serviceApi + '/create', data);
  }

  getMsgsList(channelName) {
    return this.httpService.getRequest(this.serviceApi + `/channel/${channelName}`);
  }


}
