import { Local } from "../shared/model/local.model";

export class Evento {
  local: Local;

  descricao: string;

  dataFim: Date;

  id: number;

  dataIni: Date;

  nome: string;

  constructor(
    nome: string,
    descricao: string,
    dataIni: Date,
    dataFim: Date,
    local: Local
  ) {
    this.nome = nome;
    this.descricao = descricao;
    this.dataIni = dataIni;
    this.dataFim = dataFim;
    this.local = local;
  }
}
